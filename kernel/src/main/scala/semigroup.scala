package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Semigroup")
trait Semigroup[F[_]] {
  def append[A](a: F[A], b: => F[A]): F[A]
}

trait SemigroupOps {
  def (a: F[A]) append[F[_], A](b: => F[A]) given (S: Semigroup[F]) = S.append(a, b)
  def (a: F[A]) ++[F[_], A](b: => F[A]) given (S: Semigroup[F]) = S.append(a, b)
}

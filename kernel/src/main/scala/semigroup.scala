package nequi.dotz

@implicitNotFound("Instances of type ${F} do not have instances of Semigroup")
trait Semigroup[F[_]] {
  def append[A](a: F[A], b: => F[A]): F[A]
}

@implicitNotFound("Values of type ${A} do not have instances of SemigroupV")
trait SemigroupV[A] {
  def append(a: A, b: => A): A
}

trait SemigroupOps {
  def (a: A) sappend[A](b: => A) given (S: SemigroupV[A]) = S.append(a, b)
  def (a: A) +++[A](b: => A) given (S: SemigroupV[A]) = S.append(a, b)

  def (a: F[A]) append[F[_], A](b: => F[A]) given (S: Semigroup[F]) = S.append(a, b)
  def (a: F[A]) ++[F[_], A](b: => F[A]) given (S: Semigroup[F]) = S.append(a, b)
}

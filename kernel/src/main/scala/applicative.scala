package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Applicative")
trait Applicative[F[_]] given (F: Functor[F]) {
  export F.map

  def pure[A](a: => A): F[A]
}

trait ApplicativeOps {
  def (a: A) pure[F[_], A] given (A: Applicative[F]) = A.pure(a)
}

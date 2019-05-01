package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Functor")
trait Functor[F[_]] {
  def map[A, B](a: F[A])(f: A => B): F[B]
}

trait FunctorOps {
  def (a: F[A]) map[F[_], A, B](f: A => B) given (F: Functor[F]) = F.map(a)(f)
}

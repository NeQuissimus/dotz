package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Monad")
trait Monad[F[_]] given (M: Monoid[F]) given (A: Applicative[F]) {
  export M.append
  export M.unit
  export A.map
  export A.pure

  def bind[A, B](fa: F[A])(f: A => F[B]): F[B]
}

trait MonadOps {
  def (fa: F[A]) bind[F[_], A, B](f: A => F[B]) given (M: Monad[F]) = M.bind(fa)(f)
  def (fa: F[A]) flatMap[F[_], A, B](f: A => F[B]) given (M: Monad[F]) = M.bind(fa)(f)
}

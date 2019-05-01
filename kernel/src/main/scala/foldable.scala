package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Foldable")
trait Foldable[F[_]] {
  def foldMap[A, B[_], C](fa: F[A])(f: A => B[C]) given (M: Monoid[B]): B[C]
  def foldRight[A, B](fa: F[A], zero: => B)(f: (A, => B) => B): B
}

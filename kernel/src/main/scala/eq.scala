package nequi.dotz

@implicitNotFound("Instances of type ${A} cannot be compared using ≡ or ≢, no Eq instance has been found")
trait Eq[A] {
  def eq(a: A, b: A): Boolean
}

object Eq {
  def derived[A] = new Eq[A] { def eq(a: A, b: A) = a eq b }
}

trait EqOps {
  def (a: A) ≡[A](b: A) given (E: Eq[A]): Boolean = E.eq(a, b)
  def (a: A) ≢[A](b: A) given (E: Eq[A]): Boolean = !E.eq(a, b)
}

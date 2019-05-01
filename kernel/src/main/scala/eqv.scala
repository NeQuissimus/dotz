package nequi.dotz

@implicitNotFound("Instances of type ${A} cannot be compared using === or =/=, no Eqv instance has been found")
trait Eqv[A] {
  def eqv(a: A, b: A): Boolean
}

trait EqvOps {
  def (a: A) ===[A](b: A) given (E: Eqv[A]): Boolean = E.eq(a, b)
  def (a: A) =/=[A](b: A) given (E: Eqv[A]): Boolean = !E.eq(a, b)
}

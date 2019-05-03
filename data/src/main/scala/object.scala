package nequi.dotz

trait Object[A](val obj: A) {
  def E: Eqv[A]
  def H: Hash[A]
  def S: Show[A]

  export obj._

  final override def equals(other: Any): Boolean = other match {
    case x: A => E.eqv(obj, x) // TypeTag?
    case _ => false
  }
  final override def hashCode(): Int = H.hash(obj)
  final override def toString(): String = S.shows(obj)
}

trait ObjectOps {
  def (a: A) sane[A] given (EA: Eqv[A]) given (HA: Hash[A]) given (SA: Show[A]) = new Object[A](a) {
    val E = EA
    val H = HA
    val S = SA

  }
}

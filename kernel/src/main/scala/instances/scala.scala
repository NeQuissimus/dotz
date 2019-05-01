package nequi.dotz

trait ScalaInstances extends ScalaIntInstances with ScalaStringInstances

trait ScalaIntInstances {
  implied for Eq[Int] { def eq(a: Int, b: Int) = a eq b }
  implied for Eqv[Int] { def eqv(a: Int, b: Int) = a eq b }
  implied for Order[Int] { def compare(a: Int, b: Int) = (java.lang.Integer.compare(a, b)) match {
    case i if i < 0 => Ordering.LT
    case i if i ≡ 0 => Ordering.EQ
    case _ => Ordering.GT
  }}
  implied for Show[Int] { def shows(a: Int) = a.toString }
}

trait ScalaStringInstances {
  implied for Eq[String] { def eq(a: String, b: String) = a eq b }
  implied for Eqv[String] { def eqv(a: String, b: String) = a.equals(b) }
  implied for Show[String] { def shows(a: String) = a }
}

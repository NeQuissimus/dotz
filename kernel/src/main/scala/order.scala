package nequi.dotz

enum Ordering derives Eq {
  case LT, GT, EQ
}

@implicitNotFound("Instances of type ${A} do not have an order")
trait Order[A] given (E: Eqv[A]) {
  export E.eqv

  def compare(a: A, b: A): Ordering
}

trait OrderOps {
  def (a: A) compare[A](b: A) given (O: Order[A]) = O.compare(a, b)
  def (a: A) <[A](b: A) given (O: Order[A]) = O.compare(a, b) ≡ Ordering.LT
  def (a: A) >[A](b: A) given (O: Order[A]) = O.compare(a, b) ≡ Ordering.GT

  def (a: A) <=[A](b: A) given (O: Order[A]) = {
    val r = O.compare(a, b)
    r ≡ Ordering.LT || r ≡ Ordering.EQ
  }

  def (a: A) >=[A](b: A) given (O: Order[A]) = {
    val r = O.compare(a, b)
    r ≡ Ordering.GT || r ≡ Ordering.EQ
  }
}

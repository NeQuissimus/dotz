package nequi

package object dotz {
  type Id[A] = A

  type implicitNotFound = scala.annotation.implicitNotFound

  inline def the[T](implicit x: T): x.type = x

  val ??? = scala.Predef.???
}

package dotz {
  implied instances for AllInstances
  implied syntax for AllOps

  trait AllInstances extends ScalaInstances with ListInstances

  trait AllOps extends UniversalOps
    with ApplicativeOps
    with EqOps
    with EqvOps
    with FunctorOps
    with MonadOps
    with MonoidOps
    with OrderOps
    with SemigroupOps
    with ShowOps

  trait UniversalOps {
    def (a: A) eq[A, B](b: B): Boolean = scala.Predef.eq(a, b)
  }
}

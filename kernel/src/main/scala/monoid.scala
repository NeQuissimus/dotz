package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Monoid")
trait Monoid[F[_]] given (S: Semigroup[F]) {
  export S.append

  def unit[A]: F[A]
}

trait MonoidOps {
  def (a: A) unit[F[_], A] given (M: Monoid[F]) = M.unit[A]
}

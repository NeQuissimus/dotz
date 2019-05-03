package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Monoid")
trait Monoid[F[_]] given (S: Semigroup[F]) {
  export S.append

  def unit[A]: F[A]
}

@implicitNotFound("Instances of type ${A} do not have instances of Monoid")
trait MonoidV[A] given (S: SemigroupV[A]) {
  export S.append

  def unit[A]: A
}

trait MonoidOps {
  def (a: A) unit[A] given (M: MonoidV[A]) = M.unit[A]

  def (a: F[A]) unit[F[_], A] given (M: Monoid[F]) = M.unit[A]
}

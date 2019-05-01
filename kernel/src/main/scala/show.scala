package nequi.dotz

@implicitNotFound("Values of type ${A} do not have a Show instance and cannot be printed safely")
trait Show[A] {
  def shows(a: A): String
}

trait ShowOps {
  def (a: A) shows[A] given (S: Show[A]): String = S.shows(a)
}

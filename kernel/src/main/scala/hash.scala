package nequi.dotz

@implicitNotFound("Instances of type ${A} do not have instances of Hash")
trait Hash[A] {
  def hash(a: A): Int
}

trait HashOps {
  def (a: A) hash[A] given (H: Hash[A]) = H.hash(a)
}

package nequi.dotz

opaque type Maybe[A] = Option[A]

object Maybe {
  def Nothing[A]: Maybe[A] = None.asInstanceOf[Maybe[A]]

  def apply[A](a: A): Maybe[A] = Option(a)
  def fromOption[A](a: Option[A]): Maybe[A] = a
}

trait MaybeInstances {
  implied [A] given (S: SemigroupV[A]) for SemigroupV[Maybe[A]] { def append(a: Maybe[A], b: => Maybe[A]): Maybe[A] = (a, b) match {
    case (Some(a: A), Some(b: A)) => Maybe(S.append(a, b))
    case (_, x: Some[A]) => Maybe.fromOption(x)
    case (x: Some[A], _) => Maybe.fromOption(x)
    case _ => (Maybe.Nothing: Maybe[A])
  } }
}

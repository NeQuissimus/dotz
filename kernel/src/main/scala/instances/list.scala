package nequi.dotz

trait ListInstances {
  implied for Semigroup[List] { def append[A](a: List[A], b: => List[A]): List[A] = a ++ b  }
  implied for Monoid[List] { def unit[A]: List[A] = List.empty[A] }
  implied for Functor[List] { def map[A, B](a: List[A])(f: A => B): List[B] = a.map(f) }
  implied for Applicative[List] { def pure[A](a: => A): List[A] = List(a) }
  implied for Monad[List] { def bind[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f) }
}

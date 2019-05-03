package bla

import nequi.dotz._
import implied nequi.dotz.syntax._
import nequi.dotz.syntax._
import implied nequi.dotz.instances._
import nequi.dotz.data._
import implied nequi.dotz.data._

class Default extends AnyRef {
  def boo() = scala.Predef.println("boo")
}

implied for Eqv[Default] { def eqv(a: Default, b: Default) = ??? }
implied for Hash[Default] { def hash(a: Default) = ??? }
implied for Show[Default] { def shows(a: Default): String = "default!" }

object Test extends scala.App {
  scala.Predef.println(Maybe(null))

  val b = the[SemigroupV[Maybe[Int]]]

  val m: Maybe[Int] = Maybe(1)

  "lala" +++ "lala"

  m +++ m

  "lala" === "lala"

  scala.Predef.println(b.append(m, m))

  val d = new Default

  d.sane[Default].boo()

  scala.Predef.println(d)
  scala.Predef.println(d.sane[Default])
}

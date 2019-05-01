organization in ThisBuild := "com.nequissimus"

scalaVersion in ThisBuild := "0.14.0-RC1"

scalacOptions in ThisBuild := Seq(
  "-language:strictEquality",
  "-Yno-predef"
)

lazy val kernel = project
  .in(file("kernel"))
  .settings(
    name := "dotz-kernel",
  )

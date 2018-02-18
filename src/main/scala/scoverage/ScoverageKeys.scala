package scoverage

import sbt._

object ScoverageKeys {
  lazy val coverageEnabled = settingKey[Boolean]("controls whether code instrumentation is enabled or not")
  lazy val coverageReport = taskKey[Unit]("run report generation")
  lazy val coverageAggregate = taskKey[Unit]("aggregate reports from subprojects")
  lazy val coverageExcludedPackages = settingKey[String]("regex for excluded packages")
  lazy val coverageExcludedFiles = settingKey[String]("regex for excluded file paths")
  lazy val coverageMinimum = settingKey[Double]("scoverage-minimum-coverage-stmt-total")
  lazy val coverageMinimumBranchTotal = settingKey[Double]("scoverage-minimum-coverage-branch-total")
  lazy val coverageMinimumStmtPerPackage = settingKey[Double]("scoverage-minimum-coverage-stmt-per-package")
  lazy val coverageMinimumBranchPerPackage = settingKey[Double]("scoverage-minimum-coverage-branch-per-package")
  lazy val coverageMinimumStmtPerFile = settingKey[Double]("scoverage-minimum-coverage-stmt-per-file")
  lazy val coverageMinimumBranchPerFile = settingKey[Double]("scoverage-minimum-coverage-branch-per-file")
  lazy val coverageFailOnMinimum = settingKey[Boolean]("if coverage is less than this value then fail build")
  lazy val coverageHighlighting = settingKey[Boolean]("enables range positioning for highlighting")
  lazy val coverageOutputCobertura = settingKey[Boolean]("enables cobertura XML report generation")
  lazy val coverageOutputXML = settingKey[Boolean]("enables xml report generation")
  lazy val coverageOutputHTML = settingKey[Boolean]("enables html report generation")
  lazy val coverageOutputDebug = settingKey[Boolean]("turn on the debug report")
  lazy val coverageOutputTeamCity = settingKey[Boolean]("turn on teamcity reporting")
  lazy val coverageScalacPluginVersion = settingKey[String]("version of scalac-scoverage-plugin to use")

  def coverageMinima = Def.setting {
    CoverageMinima(
      total = CoverageMinimum(
        statement = coverageMinimum.value,
        branch = coverageMinimumBranchTotal.value),
      perPackage = CoverageMinimum(
        statement = coverageMinimumStmtPerPackage.value,
        branch = coverageMinimumBranchPerPackage.value
      ),
      perFile = CoverageMinimum(
        statement = coverageMinimumStmtPerFile.value,
        branch = coverageMinimumBranchPerFile.value
      )
    )
  }

  case class CoverageMinimum(
    statement: Double,
    branch: Double
  )

  case class CoverageMinima(
    total: CoverageMinimum,
    perPackage: CoverageMinimum,
    perFile: CoverageMinimum
  )

}

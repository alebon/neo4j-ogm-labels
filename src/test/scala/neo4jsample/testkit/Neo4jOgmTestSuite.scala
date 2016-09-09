package neo4jsample.testkit

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver
import org.neo4j.ogm.service.Components
import org.neo4j.test.TestGraphDatabaseFactory
import org.scalatest.{BeforeAndAfter, WordSpec}

trait Neo4jOgmTestSuite extends BeforeAndAfter {
  this: WordSpec =>

  def debug = false

  var testServer: GraphDatabaseService = _

  before {
    val impermanentDb = new TestGraphDatabaseFactory().newImpermanentDatabase()
    Components.setDriver(new EmbeddedDriver(impermanentDb))

    testServer = impermanentDb
  }

  after {
    testServer.shutdown()
  }
}

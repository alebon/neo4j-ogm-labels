package neo4jsample.model

import org.neo4j.ogm.annotation.{NodeEntity, Property}
import org.neo4j.ogm.annotations.Labels

@NodeEntity
class Project extends Entity {

  @Property
  var name: String = _

  @Labels
  val labels: java.util.Collection[String] = new java.util.ArrayList[String]()

  def this(tenant: Tenant, name: String) {
    this()
    this.name = name
    this.labels.add(tenant.name)
  }

  def hasLabel(label: String): Boolean = {
    this.labels.contains(label)
  }
}

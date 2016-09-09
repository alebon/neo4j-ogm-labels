package neo4jsample.model

import org.neo4j.ogm.annotation.{NodeEntity, Property}

@NodeEntity
class Tenant extends Entity {

  @Property
  var name: String = _

  def this(name: String) {
    this()
    this.name = name
  }
}

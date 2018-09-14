/*
 * Copyright 2016 Johannes Rudolph
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.virtualvoid.sbt.graph
package rendering

object FlatList {
  def render(display: Module ⇒ String)(graph: ModuleGraph): String =
    graph.modules.values.toSeq
      .distinct
      .filterNot(_.isEvicted)
      .sortBy(m ⇒ (m.id.organisation, m.id.name))
      .map(display)
      .mkString("\n")
}

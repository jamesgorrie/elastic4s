package com.sksamuel.elastic4s.requests.searches.template

import com.sksamuel.elastic4s.json.{XContentBuilder, XContentFactory}
import com.sksamuel.elastic4s.requests.searches.PutSearchTemplateRequest
import com.sksamuel.elastic4s.requests.searches.queries.QueryBuilderFn

object PutSearchTemplateBuilderFn {

  def apply(request: PutSearchTemplateRequest): XContentBuilder = {

    val builder = XContentFactory.jsonBuilder().startObject("template")
    request.body.foreach(builder.rawField("query", _))
    request.query.map(QueryBuilderFn(_)).foreach(builder.rawField("query", _))
    builder.endObject().endObject()
  }
}

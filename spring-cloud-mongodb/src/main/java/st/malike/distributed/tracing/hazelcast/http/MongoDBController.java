package st.malike.distributed.tracing.hazelcast.http;

import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor malike_st
 */
@RestController
@RequestMapping("mongodb")
public class MongoDBController {

  private static final Logger logger = Logger.getLogger(MongoDBController.class.getName());
  @Autowired
  private MongoTemplate mongoTemplate;

  @RequestMapping(value = {
      "/api/read/{id}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Map read(@PathVariable String id, HttpServletResponse response) {
    logger.info("readFromMongoDB(\"" + id + "\"");
    Query query = new Query();
    query.addCriteria(new Criteria("idField").is(Integer.parseInt(id)));
    return mongoTemplate.findOne(query, Map.class, "tracing_mongodb");
  }

  @RequestMapping(value = {
      "/api/write/{id}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String write(@PathVariable String id, @RequestBody String param, HttpServletResponse
      response) {
    logger.info("writeToMongoDB(\"" + id + "\"");
    mongoTemplate.save(param, "tracing_mongodb");
    return param;
  }


}

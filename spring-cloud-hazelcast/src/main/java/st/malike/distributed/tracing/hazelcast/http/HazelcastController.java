package st.malike.distributed.tracing.hazelcast.http;

import com.hazelcast.core.HazelcastInstance;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("hazelcast")
public class HazelcastController {

  private static final Logger logger = Logger.getLogger(HazelcastController.class.getName());
  @Autowired
  private HazelcastInstance hazelcastInstance;

  @RequestMapping(value = {
      "/api/read/{id}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String read(@PathVariable String id, HttpServletResponse response) {
    logger.info("readFromHazelcast(\"" + id + "\"");
    Map<String, String> hazelCastItem = hazelcastInstance.getMap("tracing-hazelcast");
    return hazelCastItem.get(id);
  }

  @RequestMapping(value = {
      "/api/write/{id}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String write(@PathVariable String id, @RequestBody String param, HttpServletResponse
      response) {
    logger.info("writeToHazelcast(\"" + id + "\"");
    Map<String, String> hazelCastItem = hazelcastInstance.getMap("tracing-hazelcast");
    hazelCastItem.put(id, param);
    return hazelCastItem.get(id);
  }


}

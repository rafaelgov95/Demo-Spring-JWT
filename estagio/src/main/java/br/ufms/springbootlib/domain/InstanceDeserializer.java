package br.ufms.springbootlib.domain;//package br.ufms.springbootlib.domain;
//
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.google.gson.JsonParser;
//
//public class InstanceDeserializer extends JsonDeserializer<GenericEntity> {
//    @Override
//    public GenericEntity deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
//        ObjectNode root = (ObjectNode) mapper.readTree(jp);
//        Class<? extends GenericEntity> instanceClass = null;
//        if(checkConditionsForUserInstance()) {
//            instanceClass = UserInstance.class;
//        } else {
//            instanceClass = HardwareInstance.class;
//        }
//        if (instanceClass == null){
//            return null;
//        }
//        return mapper.readValue(root, instanceClass );
//    }
//}
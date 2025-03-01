package persistence;

import org.json.JSONObject;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public interface Writable {

    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}


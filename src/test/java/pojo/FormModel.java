package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FormModel {

    /**
     * Name
     */
    private String name;

    /**
     * Email
     */
    private String email;

    /**
     * Interests type
     */
    private String type;
}
package example.day08.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor@AllArgsConstructor
public class MemberDto {
   private int mno;
   private String mname;
   private String mphone;
   private int mage;
}

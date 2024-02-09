package boardcamp.boardcamp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
  
  @NotBlank(message = "Customer name is required")
  @Size(max = 50)
  private String name;

  @NotBlank(message = "Customer cpf is required")
  @Size(min = 11, max = 11)
  // @Pattern(regexp = "(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})")
  private String cpf;
}

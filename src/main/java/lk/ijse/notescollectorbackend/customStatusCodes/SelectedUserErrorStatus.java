package lk.ijse.notescollectorbackend.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserErrorStatus {
    private String statusCode;
    private String statusMessage;
}

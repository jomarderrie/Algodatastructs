package helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    String postcode;
    String straatNaam;
    String huisNummer;
    String gemeente;
    String province;
    String huisPrijs;
}

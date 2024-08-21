package db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDto {
    private int    num     = 0;
    private int writer  = 0;
    private String name = "";
    private String title   = "";
    private String content = "";
    private String regtime = "";
    private int    hits    = 0;
}
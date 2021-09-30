package healthApp.healthPrj.common.dto;

import lombok.Data;

@Data
public class Result<T> {

    private Long pageDataCount;
    private int dataCount;
    private T data;

    public Result(Long pageDataCount, T data) {
        this.pageDataCount = pageDataCount;
        this.data = data;
    }

    public Result(int dataCount, T data) {
        this.dataCount = dataCount;
        this.data = data;
    }
}

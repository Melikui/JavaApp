import lombok.extern.slf4j.Slf4j;
import util.ExcelUtil;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) throws IOException {
        // log.info("日志记录: {}", numbers);
        ExcelUtil.writeExcel();
    }
}

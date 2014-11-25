package common.base.app.farmerfriend.Classes.Parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import common.base.app.farmerfriend.Classes.Result.IWebResult;

public interface IJsonParser {
	public final String Encoding = "UTF-8";
	public List<IWebResult> readJsonStream(InputStream in)throws IOException;
}

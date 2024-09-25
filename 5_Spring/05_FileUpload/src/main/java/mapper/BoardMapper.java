package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
	void insert(Board vo);
	List<Board> print(Paging paging);
	void update(Board vo);
	Board select(int no);
	void delete(int no);
	int total();
}

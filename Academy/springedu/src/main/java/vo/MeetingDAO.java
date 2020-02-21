package vo;
import java.util.List;

public interface MeetingDAO {
	public List<MeetingVO> listAll();
	public boolean insert(MeetingVO vo);
	public List<MeetingVO> search(String keyword);
	public boolean delete(int id);
	public boolean update(MeetingVO vo);
}


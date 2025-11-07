package example2.실습.실습4_플러터;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    // 1. Todo 등록 (저장)
    public TodoDto createTodo( TodoDto todoDto ){
        TodoEntity entity = todoDto.toEntity();
        TodoEntity savedEntity = todoRepository.save(entity);
        if( savedEntity.getId() >= 0){return savedEntity.toDto();}
        return todoDto;
    }

    // 2. 전체조회
    public List<TodoDto> getTodoList(){
        List<TodoEntity> todoEntityList = todoRepository.findAll();

        List<TodoDto> todoDtoList = todoEntityList
                .stream().map(TodoEntity :: toDto)
                .collect(Collectors.toList() );

        return todoDtoList;
    }
}

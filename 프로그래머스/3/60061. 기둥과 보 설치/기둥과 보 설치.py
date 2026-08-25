def check(frame) :
    for x, y, frame_type in frame :
        
        # 기둥
        if frame_type == 0 :
            if y == 0 :
                continue
                
            if [x, y - 1, 0] in frame : 
                continue
            
            if [x - 1, y, 1] in frame :
                continue
            
            if [x, y, 1] in frame :
                continue
            
            return False
        
        # 보
        else :
            if [x, y - 1, 0] in frame :
                continue
            
            if [x + 1, y - 1, 0] in frame :
                continue
                
            if ([x - 1, y, 1] in frame and
                    [x + 1, y, 1] in frame) :
                continue
            
            return False
    
    return True
        
                

def del_column(x, y, frame) :
    frame.remove([x, y, 0])
    
    if not check(frame) :
        frame.append([x, y, 0])
    
def create_column(x, y, frame):
    frame.append([x, y, 0])

    if not check(frame):
        frame.remove([x, y, 0])


def del_row(x, y, frame):
    frame.remove([x, y, 1])

    if not check(frame):
        frame.append([x, y, 1])


def create_row(x, y, frame):
    frame.append([x, y, 1])

    if not check(frame):
        frame.remove([x, y, 1])



def solution(n, build_frame):
    
    frame = []
    
    # [ x좌표, y좌표, 기둥 or 보, 삭제 or 설치]
    for x, y, frame_type, action in build_frame :
        if frame_type == 0 and action == 0 :
            del_column(x, y, frame)
            
        elif frame_type == 0 and action == 1 :
            create_column(x, y, frame)
            
        elif frame_type == 1 and action == 0 :
            del_row(x, y, frame)
            
        elif frame_type == 1 and action == 1 :
            create_row(x, y, frame)
    
    frame.sort()
    return  frame
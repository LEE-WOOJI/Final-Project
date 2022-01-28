select j.seq,j.refchalseq,j.refnickname,c.chalname,c.startdate,c.enddate,c.personnel,c.chalinfo,c.tag,c.chalstat
from member m
left outer join joinchal j on m.nickname = j.refnickname
left outer join chal c on c.chalseq = j.refchalseq
where m.nickname ='JORDAN';

select * from member;
select nickname from member where seq=30;
select * from chal;
select * from joinchal;

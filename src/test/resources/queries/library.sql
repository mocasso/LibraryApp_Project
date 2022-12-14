select count(id) from users;
select count(distinct id) from users;

select  * from users;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;

select count(*) as borrowedBooks from users u
inner join book_borrow b on u.id = b.user_id where is_returned = 0;


select name from book_categories;

select bc.name,count(*) from book_borrow bb
                                 inner join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;
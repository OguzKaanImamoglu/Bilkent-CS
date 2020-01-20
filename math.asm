li $s0, 0 #the result

la $a0,prompt1	# print string before result
li $v0,4
syscall

li $v0 5
syscall
move $t1 $v0

la $a0,prompt2	# print string before result
li $v0,4
syscall

li $v0 5
syscall
move $t2 $v0

la $a0,prompt3	# print string before result
li $v0,4
syscall

li $v0 5
syscall
move $t3 $v0

la $a0,prompt4	# print string before result
li $v0,4
syscall

li $v0 5
syscall
move $t4 $v0

la $a0,prompt5	# print string before result
li $v0,4
syscall

li $v0 5
syscall
move $t5 $v0

sub $s0,$t2,$t3
mul $s0,$s0,$t1
mul $s0,$s0, 2
add $s0,$s0,$t4
rem $s0,$s0,$t5

la $a0,result	
li $v0,4
syscall

move $a0,$s0	
li $v0,1
syscall
        


	.data
prompt1:.asciiz "Enter A  "
prompt2:.asciiz "Enter B "
prompt3:.asciiz "Enter C  "
prompt4:.asciiz "Enter D "
prompt5:.asciiz "Enter E "
result:.asciiz "The result is:     "
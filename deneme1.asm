# read n from console
la $a0,prompt1 # print string before
li $v0,4
syscall

li $v0 5
syscall
move $t0 $v0

# allocate dynamic memory
sll $a0 $v0 2    # sll performs $a0 = $v0 x 2^2
li $v0 9    #9 is the system code for service(sbrk) whoes work is        
syscall     #to allocate dynamic memory

move $t1 $zero
move $t2 $v0

li $t3 0 #counter

li $s5 2 #this holds 2

div $s0, $t0, $s5 # s0 is limit


move $t6 $t2 # t6 holds first value

loop:
    bge $t1 $t0 end
    
    la $a0,prompt2 # print string before
    li $v0,4
    syscall

    # read in and store int
    li $v0 5
    syscall
    sw $v0 0($t2)

    addi $t1 $t1 1
    addi $t2 $t2 4
    j loop

end:

while:
	bge $t3 $s0 end2
	
	subi $t2, $t2,4
	
	lw $t4  0($t6)
	lw $t5  0($t2)
	
	bne $t5 $t4 printno
	
	addi $t6, $t6, 4
	
	
	addi $t3, $t3, 1


	j while
end2:
	
	la $a0,yes	# print string before result
	li $v0,4
	syscall
	
	j theend


printno: 

	la $a0,no	# print string before result
	li $v0,4
	syscall

theend:


	.data
result:	.space 12
yes:	.asciiz "Yes"
no:	.asciiz "No"
prompt1:.asciiz "Enter  array size: "
prompt2:.asciiz "Enter array element: "



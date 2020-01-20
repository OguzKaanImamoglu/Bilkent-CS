# read n from console
la $a0,prompt1	# print string before result
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
li $s1, 0
li $s2, 0
move $t4, $t2

loop:
    bge $t1 $t0 end
    
    la $a0,prompt2	# print string before result
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

print:
	slt  $t6, $s2, $t0 # counter less than result
	beq  $t6, $0, printend
	
	lw $t3 0($t4)
	move $a0,$t3
	li $v0,1
	syscall	
	
	addi $t4, $t4, 4

	addi $s2, $s2, 1
	j print

printend:

printreverse:
	
	slt  $t6, $s1, $t0 # counter less than result
	beq  $t6, $0, finish
	
	subi $t2 $t2 4
	
	lw $t3 0($t2)
	move $a0,$t3
	li $v0,1
	syscall	
	
	
	addi $s1, $s1, 1
	j printreverse
	
finish:
	
	.data
prompt1:.asciiz "Enter  array size: "
prompt2:.asciiz "Enter array element: "

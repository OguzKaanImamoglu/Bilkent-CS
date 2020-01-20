 # Oguz Kaan Imamoglu
# Course: CS224
# Section: 1
# Lab: 6

menu:
	la $a0,info1	# print string before result
        li $v0,4
        syscall
        
        la $a0,info2	# print string before result
        li $v0,4
        syscall
        
	la $a0,info3	# print string before result
        li $v0,4
        syscall
        
	la $a0,info4	# print string before result
        li $v0,4
        syscall
        
        la $a0,info5	# print string before result
        li $v0,4
        syscall
        
        la $a0,info6	# print string before result
        li $v0,4
        syscall
        
        la $a0,choice	# print string before result
    	li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t7 $v0  #t7 is the option
        
        beq  $t7,1,first
	beq  $t7,2,second       
	beq  $t7,3,third
	beq  $t7,4,fourth
	beq  $t7,5,fifth
        beq  $t7,6,sixth
        
        
        first:
        la $a0,infofirst	# print string before result
        li $v0,4
        syscall
        
                
        li $v0 5
	syscall
	move $s0 $v0  #s0 is size
        
        
        second:
        sll $a0 $v0 2    # sll performs $a0 = $v0 x 2^2
        li $v0 9    #9 is the system code for service(sbrk) whoes work is        
	syscall     #to allocate dynamic memory
	
	mul $s1 $s0 3
	li  $t0 0 #counter
	li  $t1 0 #base adress of array
	addi $sp, $sp, -4 # make space on stack to 	
 	sw  $t1, 0($sp)
	
	loop2:
	
	la $a0,prompt2	# print string before result
    	li $v0,4
    	syscall
	
	li $v0 5
    	syscall
        sw $v0 0($t1)
        
        addi $t1 $t1 1
        addi $t2 $t2 4

	blt $t0 $s1 loop2
	lw  $t1, 0($sp)
	addi $sp, $sp, 4 
	j menu
        
        third:
        j menu
        
        fourth:
        la $a0,prompt4	# print string before result
    	li $v0,4
    	syscall
        
        li $v0 5
	syscall
	move $t7 $v0  #t7 is the row number
	
	li  $t0 0 #counter
	li  $s4 0 #result
	addi $sp, $sp, -4 # make space on stack to 	
 	sw  $t1, 0($sp)
 	subi $t7 $t7 1
 	mul $t7 $t7 4
	add $t1 $t1 $t7
	
	loop4:
	lw $t4 0($t1)
	add $s4 $s4 $t4
	addi $t0 $t0 1
	mul $t5 $s0 4
        add $t1 $t1 $t5
        bgt $t0 $s0 menu
        lw  $t1, 0($sp)
	addi $sp, $sp, 4
        j loop4
        
        
        fifth:
        la $a0,prompt5	# print string before result
    	li $v0,4
    	syscall
        
        li $v0 5
	syscall
	move $t7 $v0  #t7 is the col number
	
	li  $t0 0 #counter
	li  $s5 0 #result
	addi $sp, $sp, -4 # make space on stack to 	
 	sw  $t1, 0($sp)
	mul $t6 $s0 4
	subi $t7 $t7 1
	mul $t7 $t7 $t6
	add $t1 $t1 $t7
	
	loop5:
	lw $t8 0($t1)
	add $s5 $s5 $t8
	addi $t1 $t1 4
	addi $t0 $t0 1
	bgt $t0 $s0 menu
	lw  $t1, 0($sp)
	addi $sp, $sp, 4
	j loop5
        
        
        
        sixth:
        la $a0,prompt4	# print string before result
    	li $v0,4
    	syscall
        
        li $v0 5
	syscall
	move $t7 $v0  #t7 is the row number
	
	la $a0,prompt5	# print string before result
    	li $v0,4
    	syscall
        
        li $v0 5
	syscall
	move $t9 $v0  #t9 is the col number
	
	subi $t9 $t9 1
	subi $t7 $t7 1
        
        addi $sp, $sp, -4 # make space on stack to 	
 	sw  $t1, 0($sp)
 	
 	mul $s5 $s0 4
        add $t9 $t9 $s5 
        mul $t7 $t7 4
        add $t1 $t1 $t9
        add $t1 $t1 $t7
        lw $s7 0($t1)
            
        li  $v0, 1           # service 1 is print integer
    	move $a0, $s7 # load desired value into argument register $a0, using pseudo-op
    	syscall
        
        j menu
        
   		.data
prompt2:.asciiz "\n Enter matix element \n"
prompt4:.asciiz "\n Enter the row number \n"
prompt5:.asciiz "\n Enter the col number \n"
info1:.asciiz "\n 1)Enter the size of matrix (N) \n"
info2:.asciiz "2)Enter Matrix Elements \n"
info3:.asciiz "3)Display the content\n"
info4:.asciiz "4)Row major sum \n"
info5:.asciiz "5)Col major sum\n"
info6:.asciiz "6)Display desired elements \n"
choice:.asciiz "7) Enter your choice \n"
infofirst:.asciiz "\n Enter the size of matrix (N) \n"
        
        
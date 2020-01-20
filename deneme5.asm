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
li $s1, 0 #result of 1
li $s2, 0 #result of 2
li $s3, 0 #result of 3
move $t4, $t2  #t4 first index
move $s5, $t4  #t4 first index

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
        
        la $a0,cho	# print string before result
    	li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t7 $v0  #t7 is the option
        
        beq  $t7,1,first
	beq  $t7,2,second       
	beq  $t7,3,third
	beq  $t7,4,last
	#j menu
	
first:
	move $t4, $s5 
	li $s1, 0 #result of 1 
	li $s4, 0 #counter of 1
	la $a0,val	# print string before result
        li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t6 $v0  #t6 is the value
	
loop1:
	lw $t3 0($t4) #t3 is array element
	
	bge $s4,$t0,break1
	addi $s4,$s4,1
	blt $t3, $t6, topla
	addi $t4,$t4,4
	
	j loop1
   
   topla:
   	add $s1, $s1, $t3
   	addi $t4,$t4,4
   	
   	j loop1
	  

	
break1:

	move $a0,$s1	# print string before result
        li $v0,1
        syscall
        
        la $a0,endl	# print newline
	li $v0,4
	syscall
        
        j menu

second:
	move $t4, $s5 
	li $s2, 0 #result of 2 
	li $s4, 0 #counter of 2
	la $a0,low	# print string before result
        li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t6 $v0  #t6 is the lower bound
	
	la $a0,upp	# print string before result
        li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t5 $v0  #t5 is the upper bound

loop2:
	bge $s4,$t0,break2
	addi $s4,$s4,1
	lw $t3 0($t4) #t3 is array element	
	blt $t3,$t5, firstif
	addi $t4,$t4,4
	j loop2
	
	firstif:
	bgt  $t3,$t6, topla2
	addi $t4,$t4,4
	j loop2
	
	topla2:
	add $s2,$s2,$t3
	addi $t4,$t4,4
	j loop2
	
	
break2:	
	move $a0,$s2	# print string before result
        li $v0,1
        syscall
        
        la $a0,endl	# print newline
	li $v0,4
	syscall
	j menu
	
third: 
	move $t4, $s5 
	li $s3, 0 #result of 3 
	li $s4, 0 #counter of 3
	la $a0,divdiv	# print string before result
        li $v0,4
        syscall
        
        li $v0 5
	syscall
	move $t6 $v0  #t6 is the value
	
loop3:
	bge $s4,$t0,break3
	addi $s4,$s4,1
	lw $t3 0($t4) #t3 is array element
	rem $t8,$t3,$t6
	beq $t8,0,divisions
	
	addi $t4,$t4,4
	j loop3
	
divisions:
	addi $s3,$s3,1
	addi $t4,$t4,4
	j loop3
	
break3:
	
	move $a0,$s3	# print string before result
        li $v0,1
        syscall
        
        la $a0,endl	# print newline
	li $v0,4
	syscall
        
        j menu

last:
	.data
prompt1:.asciiz "Enter  size: "
prompt2:.asciiz "Enter array element: "
info1:.asciiz "1)Find summation of numbers stored in the array which is less than an input number.\n"
info2:.asciiz "2)Find summation of numbers out of a value range specified by two numbers and display that value.\n"
info3:.asciiz "3)Display the number of occurrences of the array elements divisible by a certain input number.\n"
info4:.asciiz "4)Quit\n"
val:.asciiz "Enter the value: "
cho:.asciiz "Enter your choice: "
low:.asciiz "Enter the lower bound: "
upp:.asciiz "Enter the upper bound: "
divdiv:.asciiz "Enter the divison number: "
endl:.asciiz "\n"
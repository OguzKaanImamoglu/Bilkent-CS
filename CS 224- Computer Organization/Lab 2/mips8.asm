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
        
        la $a0,cho	# print string before result
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
        beq  $t7,6,exit
        
        first:
addi $sp, $sp, -88 # make space on stack to 				   # store one register
sw  $s0, 0($sp) 
sw  $s1, 4($sp)    
sw  $s2, 8($sp) 
sw  $s3, 12($sp)   
sw  $s4, 16($sp)   
sw  $s5, 20($sp)   
sw  $s6, 24($sp)   
sw  $s7, 28($sp) 
sw  $t0, 32($sp)    
sw  $t1, 36($sp) 
sw  $t2, 40($sp)  
sw  $t3, 44($sp)   
sw  $t4, 48($sp)   
sw  $t5, 52($sp)   
sw  $t6, 56($sp)     
sw  $t7, 60($sp)  
sw  $t8, 64($sp)    
sw  $t9, 68($sp)    
sw  $a0, 72($sp)  
sw  $a1, 76($sp)  
sw  $v0, 80($sp)  
sw  $v1, 84($sp)  
jal   readArray

la $a0,prompt3	# print string before result
li $v0,4
syscall

lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4

move $a0,$v0	
li $v0,1
syscall


la $a0,prompt4	# print string before result
li $v0,4
syscall

move $a0,$v1	
li $v0,1
syscall

j theEnd

readArray:
li $v1, 0
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
    addi $v1, $v1, 1
    j loop

end:
   la $v0, ($t4)
   addi $sp, $sp, -4
   sw  $v0, 0($sp)  
   jr   $ra

theEnd:
lw  $v1, 84($sp)  
lw  $v0, 80($sp)  
lw  $a1, 76($sp) 
lw  $a0, 72($sp)  
lw  $t9, 68($sp) 
lw  $t8, 64($sp)  
lw  $t7, 60($sp) 
lw  $t6, 56($sp)  
lw  $t5, 52($sp)
lw  $t4, 48($sp)  
lw  $t3, 44($sp)   
lw  $t2, 40($sp)  
lw  $t1, 36($sp) 
lw  $t0, 32($sp) 
lw  $s7, 28($sp) 
lw  $s6, 24($sp)   
lw  $s5, 20($sp)  
lw  $s4, 16($sp)   
lw  $s3, 12($sp) 
lw  $s2, 8($sp)       
lw  $s1, 4($sp)        
lw  $s0, 0($sp) 
addi $sp, $sp, 88 
j menu
        
        second:
addi $sp, $sp, -88 # make space on stack to 				   # store one register
sw  $s0, 0($sp) 
sw  $s1, 4($sp)    
sw  $s2, 8($sp) 
sw  $s3, 12($sp)   
sw  $s4, 16($sp)   
sw  $s5, 20($sp)   
sw  $s6, 24($sp)   
sw  $s7, 28($sp) 
sw  $t0, 32($sp)    
sw  $t1, 36($sp) 
sw  $t2, 40($sp)  
sw  $t3, 44($sp)   
sw  $t4, 48($sp)   
sw  $t5, 52($sp)   
sw  $t6, 56($sp)     
sw  $t7, 60($sp)  
sw  $t8, 64($sp)    
sw  $t9, 68($sp)    
sw  $a0, 72($sp)  
sw  $a1, 76($sp)  
sw  $v0, 80($sp)  
sw  $v1, 84($sp)  


jal   readArray2



lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4

move $a0, $v0
move $a1, $v1

addi $sp, $sp, -8
#sw  $a0, 0($sp) 
sw  $a1, 0($sp) 
sw  $t3, 4($sp) 

jal bubble

lw  $t3, 4($sp)
lw  $a1, 0($sp) 
#lw  $a0, 0($sp) 

addi $sp, $sp, 8

jal printArray2

j theEnd2

readArray2:
li $v1, 0
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

loop61:
    bge $t1 $t0 end61
    
    la $a0,prompt2	# print string before result
    li $v0,4
    syscall

    # read in and store int
    li $v0 5
    syscall
    sw $v0 0($t2)

    addi $t1 $t1 1
    addi $t2 $t2 4
    addi $v1, $v1, 1
    j loop61

end61:
   la $v0, ($t4)
   addi $sp, $sp, -4
   sw  $v0, 0($sp)  
   jr   $ra
   
   
bubble:
move $t0, $a0
move $t1, $a1
li $t9, 0 # counter
bubbleloop:
beq $a1, 0, blend
beq $t9, $t1, bubblend
lw $t2,0($a0)
addi $a0, $a0, 4
lw $t3, 0($a0)
subi $a1, $a1, 1
abs $t7, $t2
abs $t8, $t3
blt $t7, $t8, swap
j bubbleloop

swap:
sw $t2, 0($a0)
subi $a0, $a0, 4
sw $t3, 0($a0)
addi $a0, $a0, 4
j bubbleloop

blend:
move $a1, $t1
move $a0, $t0
addi $t9,$t9,1
j bubbleloop

bubblend:

jr   $ra


 printArray2:
 loopprint:
 beq $a1, 0, printEnd2
 
 lw $t3 0($a0)
 addi $sp, $sp, 4  # make space on stack to 				   # store one register
 sw  $a0, 0($sp)    
 move $a0,$t3
 li $v0,1
 syscall
 lw  $a0, 0($sp)    # restore $s7 from stack
 addi $sp, $sp, 4	
 addi $a0, $a0, 4
 subi $a1, $a1, 1 
 j loopprint
 printEnd2:
 jr   $ra


theEnd2:
lw  $v1, 84($sp)  
lw  $v0, 80($sp)  
lw  $a1, 76($sp) 
lw  $a0, 72($sp)  
lw  $t9, 68($sp) 
lw  $t8, 64($sp)  
lw  $t7, 60($sp) 
lw  $t6, 56($sp)  
lw  $t5, 52($sp)
lw  $t4, 48($sp)  
lw  $t3, 44($sp)   
lw  $t2, 40($sp)  
lw  $t1, 36($sp) 
lw  $t0, 32($sp) 
lw  $s7, 28($sp) 
lw  $s6, 24($sp)   
lw  $s5, 20($sp)  
lw  $s4, 16($sp)   
lw  $s3, 12($sp) 
lw  $s2, 8($sp)       
lw  $s1, 4($sp)        
lw  $s0, 0($sp) 
addi $sp, $sp, 88 
j menu


        
        
        third:
        
addi $sp, $sp, -88 # make space on stack to 				   # store one register
sw  $s0, 0($sp) 
sw  $s1, 4($sp)    
sw  $s2, 8($sp) 
sw  $s3, 12($sp)   
sw  $s4, 16($sp)   
sw  $s5, 20($sp)   
sw  $s6, 24($sp)   
sw  $s7, 28($sp) 
sw  $t0, 32($sp)    
sw  $t1, 36($sp) 
sw  $t2, 40($sp)  
sw  $t3, 44($sp)   
sw  $t4, 48($sp)   
sw  $t5, 52($sp)   
sw  $t6, 56($sp)     
sw  $t7, 60($sp)  
sw  $t8, 64($sp)    
sw  $t9, 68($sp)    
sw  $a0, 72($sp)  
sw  $a1, 76($sp)  
sw  $v0, 80($sp)  
sw  $v1, 84($sp)  
  
jal   readArray3


lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4

move $a0, $v0
move $a1, $v1

jal third2

   la $a0,prompt5	# print string before result
   li $v0,4
   syscall
   
lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4


 move $a0,$v0
 li $v0,1
 syscall
 
  la $a0,prompt6	# print string before result
  li $v0,4
  syscall
 
 move $a0,$v1
 li $v0,1
 syscall

j theEnd3

readArray3:
li $v1, 0
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

loop97:
    bge $t1 $t0 end4
    
    la $a0,prompt2	# print string before result
    li $v0,4
    syscall

    # read in and store int
    li $v0 5
    syscall
    sw $v0 0($t2)

    addi $t1 $t1 1
    addi $t2 $t2 4
    addi $v1, $v1, 1
    j loop

end4:
   la $v0, ($t4)
   addi $sp, $sp, -4
   sw  $v0, 0($sp)  
   jr   $ra
   
   
   
third2:
   move $t0, $a0
   move $t1, $a1
   li $t3, 0
   
   loopmax:
   beq $a1, 0, break1
   lw $t2, ($a0)
   bgt $t2, $t3, setmax
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   j loopmax
  
   setmax:
   move $t3, $t2
   j loopmax

   break1:
   
   move $a0, $t0
   move $a1, $t1
   li $t2, 0
   li $t4, 0
   
   loopmax2:
   beq $a1, 0, break2
   lw $t2, ($a0)
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   bgt $t2, $t4, setmax2

   j loopmax2
  
   setmax2:
   blt $t2, $t3, cont
   j loopmax2
   
   cont:
   move $t4, $t2
   j loopmax2

   break2:
   
   move $a0, $t0
   move $a1, $t1
   li $t2, 0
   li $v0, 0
   
   loopmax3:
   beq $a1, 0, break3
   lw $t2, ($a0)
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   bgt $t2, $v0, setmax3

   j loopmax3
  
   setmax3:
   blt $t2, $t4, cont2
   j loopmax3
   
   cont2:
   move $v0, $t2
   j loopmax3

   break3:
   
   move $a0, $t0
   move $a1, $t1
   li $t2, 0
   li $t4, 0
   addi $sp, $sp, -4
   sw  $v0, 0($sp)    # store $v0 from stack
   
   loopmin:
   beq $a1, 0, break4
   lw $t2, ($a0)
   blt $t2, $t3, setmin
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   j loopmin
  
   setmin:
   move $t3, $t2
   j loopmin

   break4:
   
   move $a0, $t0
   move $a1, $t1
   li $t2, 0
   li $t4, 99
   
   loopmin2:
   beq $a1, 0, break5
   lw $t2, ($a0)
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   blt $t2, $t4, setmin2

   j loopmin2
  
   setmin2:
   bgt $t2, $t3, cont3
   j loopmin2
   
   cont3:
   move $t4, $t2
   j loopmin2

   break5:
   
   move $a0, $t0
   move $a1, $t1
   li $t2, 0
   li $v1, 99
   
   loopmin3:
   beq $a1, 0, break6
   lw $t2, ($a0)
   addi $a0, $a0, 4
   subi $a1, $a1, 1
   blt $t2, $v1, setmin3

   j loopmin3
  
   setmin3:
   bgt $t2, $t4, cont4
   j loopmin3
   
   cont4:
   move $v1, $t2
   j loopmin3

   break6:
      jr $ra   
   
theEnd3:  
lw  $v1, 84($sp)  
lw  $v0, 80($sp)  
lw  $a1, 76($sp) 
lw  $a0, 72($sp)  
lw  $t9, 68($sp) 
lw  $t8, 64($sp)  
lw  $t7, 60($sp) 
lw  $t6, 56($sp)  
lw  $t5, 52($sp)
lw  $t4, 48($sp)  
lw  $t3, 44($sp)   
lw  $t2, 40($sp)  
lw  $t1, 36($sp) 
lw  $t0, 32($sp) 
lw  $s7, 28($sp) 
lw  $s6, 24($sp)   
lw  $s5, 20($sp)  
lw  $s4, 16($sp)   
lw  $s3, 12($sp) 
lw  $s2, 8($sp)       
lw  $s1, 4($sp)        
lw  $s0, 0($sp) 
addi $sp, $sp, 88 
j menu
    
        
        fourth:
        
addi $sp, $sp, -88 # make space on stack to 				   # store one register
sw  $s0, 0($sp) 
sw  $s1, 4($sp)    
sw  $s2, 8($sp) 
sw  $s3, 12($sp)   
sw  $s4, 16($sp)   
sw  $s5, 20($sp)   
sw  $s6, 24($sp)   
sw  $s7, 28($sp) 
sw  $t0, 32($sp)    
sw  $t1, 36($sp) 
sw  $t2, 40($sp)  
sw  $t3, 44($sp)   
sw  $t4, 48($sp)   
sw  $t5, 52($sp)   
sw  $t6, 56($sp)     
sw  $t7, 60($sp)  
sw  $t8, 64($sp)    
sw  $t9, 68($sp)    
sw  $a0, 72($sp)  
sw  $a1, 76($sp)  
sw  $v0, 80($sp)  
sw  $v1, 84($sp)  
  
        
        
jal   readArray4


lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4

move $a0, $v0
move $a1, $v1

jal mode

 move $a0,$v0
 li $v0,1
 syscall

j theEnd4

readArray4:
li $v1, 0
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

loop40:
    bge $t1 $t0 end40
    
    la $a0,prompt2	# print string before result
    li $v0,4
    syscall

    # read in and store int
    li $v0 5
    syscall
    sw $v0 0($t2)

    addi $t1 $t1 1
    addi $t2 $t2 4
    addi $v1, $v1, 1
    j loop40

end40:
   la $v0, ($t4)
   addi $sp, $sp, -4
   sw  $v0, 0($sp)  
   jr   $ra
   
   
mode:
li $s0,0
li $t3,0
li $t9,0
move $t5, $a0
l:

beq $a1, 0 , break40
lw $t1, 0($a0)
addi $a0, $a0, 4
subi $a1, $a1, 1
lw $t2, 0($a0)
beq $t1, $t2, increment
bgt $s0, $t3, flag
j l

flag:

move $t3, $s0
li $s0,0
subi $t7, $a0, 4
lw $v0, ($t7)

j l

increment:
addi $s0, $s0, 1
addi $t9, $t9, 1

j l
break40:

beq $t9, 0, lastresort
j tep

lastresort:
lw $v0, ($t5)

tep:
jr   $ra

theEnd4:
lw  $v1, 84($sp)  
lw  $v0, 80($sp)  
lw  $a1, 76($sp) 
lw  $a0, 72($sp)  
lw  $t9, 68($sp) 
lw  $t8, 64($sp)  
lw  $t7, 60($sp) 
lw  $t6, 56($sp)  
lw  $t5, 52($sp)
lw  $t4, 48($sp)  
lw  $t3, 44($sp)   
lw  $t2, 40($sp)  
lw  $t1, 36($sp) 
lw  $t0, 32($sp) 
lw  $s7, 28($sp) 
lw  $s6, 24($sp)   
lw  $s5, 20($sp)  
lw  $s4, 16($sp)   
lw  $s3, 12($sp) 
lw  $s2, 8($sp)       
lw  $s1, 4($sp)        
lw  $s0, 0($sp) 
addi $sp, $sp, 88 
j menu       
        
        fifth:
        
addi $sp, $sp, -88 # make space on stack to 				   # store one register
sw  $s0, 0($sp) 
sw  $s1, 4($sp)    
sw  $s2, 8($sp) 
sw  $s3, 12($sp)   
sw  $s4, 16($sp)   
sw  $s5, 20($sp)   
sw  $s6, 24($sp)   
sw  $s7, 28($sp) 
sw  $t0, 32($sp)    
sw  $t1, 36($sp) 
sw  $t2, 40($sp)  
sw  $t3, 44($sp)   
sw  $t4, 48($sp)   
sw  $t5, 52($sp)   
sw  $t6, 56($sp)     
sw  $t7, 60($sp)  
sw  $t8, 64($sp)    
sw  $t9, 68($sp)    
sw  $a0, 72($sp)  
sw  $a1, 76($sp)  
sw  $v0, 80($sp)  
sw  $v1, 84($sp)  
        
jal   readArray

la $a0,prompt3	# print string before result
li $v0,4
syscall

lw  $v0, 0($sp)    # restore $v0 from stack
addi $sp, $sp, 4

move $a0, $v0
move $a1, $v1

jal printArray6



j theEnd6

readArray6:
li $v1, 0
 # read n from console
la $a0,prompt7	# print string before result
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

loop88:
    bge $t1 $t0 end88
    
    la $a0,prompt2	# print string before result
    li $v0,4
    syscall

    # read in and store int
    li $v0 5
    syscall
    sw $v0 0($t2)

    addi $t1 $t1 1
    addi $t2 $t2 4
    addi $v1, $v1, 1
    j loop88

end88:
   la $v0, ($t4)
   addi $sp, $sp, -4
   sw  $v0, 0($sp)  
   jr   $ra
   
   
printArray6:
 loopprint6:
 beq $a1, 0, printEnd6
 
 lw $t3 0($a0)
 addi $sp, $sp, 4  # make space on stack to 				   # store one register
 sw  $a0, 0($sp)    
 move $a0,$t3
 li $v0,1
 syscall
 lw  $a0, 0($sp)    # restore $s7 from stack
 addi $sp, $sp, 4	
 addi $a0, $a0, 4
 subi $a1, $a1, 1 
 j loopprint6
 printEnd6:
 jr   $ra


theEnd6:
        
lw  $v1, 84($sp)  
lw  $v0, 80($sp)  
lw  $a1, 76($sp) 
lw  $a0, 72($sp)  
lw  $t9, 68($sp) 
lw  $t8, 64($sp)  
lw  $t7, 60($sp) 
lw  $t6, 56($sp)  
lw  $t5, 52($sp)
lw  $t4, 48($sp)  
lw  $t3, 44($sp)   
lw  $t2, 40($sp)  
lw  $t1, 36($sp) 
lw  $t0, 32($sp) 
lw  $s7, 28($sp) 
lw  $s6, 24($sp)   
lw  $s5, 20($sp)  
lw  $s4, 16($sp)   
lw  $s3, 12($sp) 
lw  $s2, 8($sp)       
lw  $s1, 4($sp)        
lw  $s0, 0($sp) 
addi $sp, $sp, 88 
j menu         
        
        
        
        
        
        exit:
		.data
prompt1:.asciiz "Enter  size: "
prompt2:.asciiz "Enter array element: "
info1:.asciiz "\n 1) Read Array.\n"
info2:.asciiz "2)Bubble Sort.\n"
info3:.asciiz "3)Thirdminthirdmax.\n"
info4:.asciiz "4)Mode.\n"
info5:.asciiz "5)Print.\n"
info6:.asciiz "6)Exit.\n"

prompt3:.asciiz "Beginning adress of array is "
prompt4:.asciiz "\n Array size is: "
prompt5:.asciiz "Third max is "
prompt6:.asciiz "\n Third min is: "
prompt7:.asciiz "\n The array is: "
val:.asciiz "Enter the value: "
cho:.asciiz "Enter your choice: "
low:.asciiz "Enter the lower bound: "
upp:.asciiz "Enter the upper bound: "
divdiv:.asciiz "Enter the divison number: "
endl:.asciiz "\n"

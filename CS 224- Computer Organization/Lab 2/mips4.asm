jal   readArray



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

jal printArray

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


printArray:
 loopprint:
 beq $a1, 0, printEnd
 
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
 printEnd:
 jr   $ra


theEnd:



	
	.data
prompt1:.asciiz "Enter  array size: "
prompt2:.asciiz "Enter array element: "
prompt3:.asciiz "Beginning adress of array is "
prompt4:.asciiz "\n Array size is: "
jal   readArray


#lw  $v0, 0($sp)    # restore $v0 from stack
#addi $sp, $sp, 4

move $a0, $v0
move $a1, $v1

jal third

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
   
   
   
third:
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
   
theEnd:
   
   	.data
prompt1:.asciiz "Enter  array size: "
prompt2:.asciiz "Enter array element: "
prompt3:.asciiz "Third max is: "
prompt4:.asciiz "\n Third min is: "
   
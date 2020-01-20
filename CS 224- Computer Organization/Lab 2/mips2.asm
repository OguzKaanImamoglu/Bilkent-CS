# allocate dynamic memory
sll $a0 $v0 2    # sll performs $a0 = $v0 x 2^2
li $v0 9    #9 is the system code for service(sbrk) whoes work is        
syscall     #to allocate dynamic memory

move $s1 $v0

la   $a0, ($s6)

addi $sp, $sp, -16  # make space on stack to 				   # store one register
sw  $s4, 0($sp)    
sw  $s5, 0($sp) 
sw  $s6, 0($sp)   
sw  $s7, 0($sp)        
jal   interactWithUser
lw  $s4, 0($sp)    # restore $s4 from stack
lw  $s5, 0($sp)    # restore $s5 from stack
lw  $s6, 0($sp)    # restore $s6 from stack
lw  $s7, 0($sp)    # restore $s7 from stack
addi $sp, $sp, 16


addi $sp, $sp, -24  # make space on stack to 				   # store one register
sw  $s1, 0($sp)    
sw  $s2, 0($sp) 
sw  $s3, 0($sp)   
sw  $s4, 0($sp)   
sw  $s5, 0($sp)   
sw  $s6, 0($sp)    
jal   convertToDec
lw  $s4, 0($sp)    # restore $s4 from stack
lw  $s5, 0($sp)    # restore $s5 from stack
lw  $s6, 0($sp)    # restore $s6 from stack
lw  $s1, 0($sp)    # restore $s1 from stack
lw  $s2, 0($sp)    # restore $s2 from stack
lw  $s3, 0($sp)    # restore $s3 from stack
addi $sp, $sp, 24


 move $a0,$v0	
 li $v0,1
 syscall



j end

  
  
  interactWithUser:
  
  	 la $a0,prompt1	# print string before result
   	 li $v0,4
   	 syscall
   	 
	li $v0,8 #take in input
        la $a0, buffer #load byte space into address
        li $a1, 20# allot the byte space for string
        la $s6, ($a0)
        la $s7, ($a0)
        
         syscall


  loop4:
  

  lbu  $s5, 0($s7) 
  beq $s5, 10, done4
  addi $s7, $s7, 1
  add $s4,$0, $s5

  
  
  
  
  j loop4
  
  done4:
   
  
  beq $s4,57,interactWithUser
  beq $s4,56,interactWithUser
  
  jr   $ra
  
  
  
convertToDec:

li $v0,0 # the result
li $s3,0 # counts how many elements
add $s2,$0, $s1

loop1:
  lbu  $s4, 0($a0) 
  

  beq $s4, 10, done1
  subi $s4, $s4, 48         
  sw $s4, ($s1)  
  addi $s1, $s1, 4
  addi $a0, $a0, 1
  addi $s3, $s3, 1
  j loop1
  
done1:	

loop2:
   beq $s3, $0, done2
   add $s5,$0, $s3
   lw $s6, 0($s2)   
   
   loop3:
      beq $s5, 1 , done3
      mul $s6, $s6, 8
      subi $s5,$s5,1
      j loop3
      
   done3:  
    
   addi $s2, $s2, 4
   add $v0, $v0, $s6
   subi $s3, $s3, 1     
   j loop2
   
done2:
  jr   $ra	
  
     
   	        
end:	   
	    	     
	       .data
prompt1:.asciiz "Enter  enter a proper octal number "
 buffer: .space 20
octalNo:   .asciiz "18642"


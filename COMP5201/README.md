## Tutorials
[NASM docs](https://www.nasm.us/xdoc/2.16.03/html/nasmdoc0.html) \
[NASM assembly lab](https://labs.bilimedtech.com/nasm/index.html) \
[NASM Tutorial](https://cratecode.com/info/nasm-tutorial) \
[x86 instruction list](https://en.wikipedia.org/wiki/X86_instruction_listings) \
[x86 OpCode Reference](http://ref.x86asm.net/) \
[x86 Assembly Guide](https://www.cs.virginia.edu/~evans/cs216/guides/x86.html) \
[x86 Registers](https://en.wikibooks.org/wiki/X86_Assembly/X86_Architecture) \
[makefile tutorial](https://makefiletutorial.com/)


## Linux
_some libraries may be needed_
- `build-essential`
- `gcc-multilib` 

[Linux SysCall Table for x86-64](https://blog.rchapman.org/posts/Linux_System_Call_Table_for_x86_64/) \
[Linux SysCall Table for x86-32](https://syscalls32.paolostivanin.com/)

_**NASM**_ \
_for building ELF32 object file with debugging details `.o`_ \
`nasm -f elf32 -g -F dwarf -o <output_objectFile> <input_asmFile>`

_**gcc**_ \
_32-bit_ \
`gcc -m32 -no-pie -nostdlib <object-file -o <output-file>`
- `-nostdlib`, when not using C libraries

_**ld**_ \
`ld -m elf_i386 -o <output_fileName> <input_objectFile>`

_**gdb**_ \
[gdb cheatsheet](https://gabriellesc.github.io/teaching/resources/GDB-cheat-sheet.pdf) \
`gdb ./ELF_binary` - to start `gdb` with the executable \
    1.`layout asm` - show each assembly line
    2.`break <some line or function name>` - set a breakpoint \
    3.`run` \
    4. `si` - step in


## Windows
_**NASM**_ \
_for building WinAPI 32-bit object file `.obj`_ \
`nasm -f win32 <filePath>`

_**zig build-exe**_ \
`zig build-exe <objectFile> -target x86-windows-gnu -lc`

_**gcc using MinGW, for `.exe`**_ \
`gcc <object-file> -o <output-file>.exe`